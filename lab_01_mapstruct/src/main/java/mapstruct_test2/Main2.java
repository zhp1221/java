package mapstruct_test2;

import mapstruct_test2.convert.StudentOptimizeConverter;
import mapstruct_test2.utils.ConverterUtil;
import model.Student;
import model.StudentVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghp
 * @date 2022-07-17 14:06
 */
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
