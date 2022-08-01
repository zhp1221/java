package mapstruct_test.converter;

import model.Student;
import model.StudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author zhanghp
 * @date 2022-07-17 13:40
 */
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
