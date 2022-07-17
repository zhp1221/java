# MapStruct 使用及通用实例化工具类

## 1. Mapstruct使用

### 1.1  依赖

> **ps**：lombok 在mapstrut上，否则Mapstuct编译获取不到类的getter，setter方法

~~~xml
		 <!-- lombok 在mapstrut上，否则编译获取不到getter，setter方法 -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
            <scope>provided</scope>
        </dependency>
		<dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct</artifactId> <!-- use mapstruct-jdk8 for Java 8 or higher -->
            <version>1.4.1.Final</version>
        </dependency>
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-jdk8</artifactId>
            <version>1.4.1.Final</version>
        </dependency>
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
            <version>1.4.1.Final</version>
        </dependency>
~~~



### 1.2 使用

+ **创建2个领域模型类**

  Student

  ~~~java
  @Data
  public class Student {
      private Integer id;
  
      private String name;
  
      private String photo;
  }
  ~~~

  ---

  StudentVO

  ~~~Java
  @Data
  public class StudentVO {
  
      private Integer id;
  
      private String name;
  
      private String photo;
      
  }
  ~~~

  ---



+ **Mapstruct映射接口类**

  ~~~Java
  @Mapper
  public interface StudentConverter {
  
      /**
       * Student 映射 StudentVO
       *
       * @param entity Student
       * @return StudentVO
       */
      @Mappings({
              @Mapping(source = "id", target = "id"),
              @Mapping(source = "name", target = "name"),
              @Mapping(source = "photo", target = "photo")
      })
      StudentVO toVO(Student entity);
  
      /**
       * List<Student> 映射 List<StudentVO>
       *
       * @param list List<Student>
       * @return List<StudentVO>
       */
      List<StudentVO> toVO(List<Student> list);
  }
  ~~~

  ----



+ **测试**

  ~~~java
  public class Main {
  
      /**
       * Mapstruct 映射
       */
      private static final StudentConverter converter;
  
      /**
       * Student
       */
      private static final Student STUDENT;
  
      /**
       * Student list
       */
      private static final List<Student> LIST;
  
      static {
          converter = Mappers.getMapper(StudentConverter.class);
  
          // po数据准备
          STUDENT = new Student();
          STUDENT.setId(1);
          STUDENT.setName("张三");
          STUDENT.setPhoto("照片");
  
          // po list 数据准备
          LIST = new ArrayList<>();
          for (int i = 0; i < 5; i++) {
              Student student = new Student();
              student.setId(i);
              student.setName("张三 : " + i);
              student.setPhoto("照片 : " + i);
              LIST.add(student);
          }
      }
  
      public static void main(String[] args) {
  
          // Student -> StudentVO
          System.out.println(getVO());
  
          // List<Student> -> List<StudentVO>
          System.out.println(getVOList());
      }
  
      /**
       * Student -> StudentVO
       *
       * @return StudentVO
       */
      public static StudentVO getVO() {
          // 转换
          return converter.toVO(STUDENT);
      }
  
      /**
       * List<Student> -> List<StudentVO>
       *
       * @return List<StudentVO>
       */
      public static List<StudentVO> getVOList() {
          // 转换
          return  converter.toVO(LIST);
      }
  }
  ~~~

## 2. 通用映射实例化方法封装

>  在[Mapstruct使用](# 1. Mapstruct使用)熟练使用后，进一步封装通用的实例映射化方法

### 2.1通用工具类准备

+ **CommonConverter**

  ~~~java
  /**
   * 规范方法
   * 
   * @author zhanghp
   * @date 2022-07-17 12:20
   */
  public interface CommonConverter<E, V> {
  
      List<V> toVO(List<E> list);
  
      V toVO(E t);
  }
  ~~~

+ **ConverterUtil**

  ~~~java
  /**
   * 通用映射工具类
   *
   * @author zhanghp
   * @date 2022-07-17 14:08
   */
  public final class ConverterUtil {
  
      /**
       * 通用po映射vo
       *
       * @param clz 映射类
       * @param po  实体
       * @param <E> 实体泛型
       * @param <V> VO反应
       * @param <C> 映射类泛型
       * @return VO
       */
      public static <E, V, C extends CommonConverter<E, V>> V changRO(Class<C> clz, E po) {
          // 初始化指定类的映射实例
          final C CONVERTER = Mappers.getMapper(clz);
          // po 映射 vo
          return CONVERTER.toVO(po);
      }
  
      /**
       * 通用 po list 映射 vo list
       *
       * @param clz 映射类
       * @param po  实体
       * @param <E> 实体泛型
       * @param <V> VO反应
       * @param <C> 映射类泛型
       * @return VO list
       */
      public static <E, V, C extends CommonConverter<E, V>> List<V> changRO(Class<C> clz, List<E> po) {
          // 初始化指定类的映射实例
          final C CONVERTER = Mappers.getMapper(clz);
          // po list 映射 vo list
          return CONVERTER.toVO(po);
      }
  }
  ~~~

+ **StudentOptimizeConverter**
  ~~~java
  @Mapper
  public interface StudentOptimizeConverter extends CommonConverter<Student, StudentVO> {
  
      /**
       * Student 映射 StudentVO
       *
       * @param entity Student
       * @return StudentVO
       */
      @Override
      @Mappings({
              @Mapping(source = "id", target = "id"),
              @Mapping(source = "name", target = "name"),
              @Mapping(source = "photo", target = "photo")
      })
      StudentVO toVO(Student entity);
  
      /**
       * List<Student> 映射 List<StudentVO>
       *
       * @param list List<Student>
       * @return List<StudentVO>
       */
      @Override
      List<StudentVO> toVO(List<Student> list);
  }
  ~~~

### 2.2 测试

~~~java
public class Main2 {

    /**
     * Student
     */
    private static final Student STUDENT;

    /**
     * Student list
     */
    private static final List<Student> LIST;

    static{
        // po数据准备
        STUDENT = new Student();
        STUDENT.setId(1);
        STUDENT.setName("张三");
        STUDENT.setPhoto("照片");

        // po list 数据准备
        LIST = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("张三 : " + i);
            student.setPhoto("照片 : " + i);
            LIST.add(student);
        }
    }

    public static void main(String[] args) {
        
        // Student -> StudentVO
        System.out.println(getVO());

        // List<Student> -> List<StudnetVO>
        System.out.println(getVOList());
    }

    /**
     * Student -> StudentVO
     *
     * @return StudentVO
     */
    public static StudentVO getVO() {
        // 转换
        return ConverterUtil.toVO(StudentOptimizeConverter.class, STUDENT);
    }

    /**
     * List<Student> -> List<StudentVO>
     *
     * @return List<StudentVO>
     */
    public static List<StudentVO> getVOList() {
        // 转换
        return ConverterUtil.toVO(StudentOptimizeConverter.class, LIST);
    }
}
~~~

