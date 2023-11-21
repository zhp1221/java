package mapstruct_test2.convert;

import mapstruct_test2.common.CommonConverter;
import model.Student;
import model.StudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author zhanghp
 * @date 2022-07-17 14:06
 */
@Mapper
public interface StudentOptimizeConverter extends CommonConverter<Student, StudentVO> {

	/**
	 * Student 映射 StudentVO
	 * @param entity Student
	 * @return StudentVO
	 */
	@Override
	@Mappings({ @Mapping(source = "id", target = "id"), @Mapping(source = "name", target = "name"),
			@Mapping(source = "photo", target = "photo") })
	StudentVO toVO(Student entity);

	/**
	 * List<Student> 映射 List<StudentVO>
	 * @param list List<Student>
	 * @return List<StudentVO>
	 */
	@Override
	List<StudentVO> toVO(List<Student> list);

}
