package mapstruct_test.converter;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import model.Student;
import model.StudentVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-18T11:11:52+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
public class StudentConverterImpl implements StudentConverter {

    @Override
    public StudentVO toVO(Student entity) {
        if ( entity == null ) {
            return null;
        }

        StudentVO studentVO = new StudentVO();

        studentVO.setId( entity.getId() );
        studentVO.setName( entity.getName() );
        studentVO.setPhoto( entity.getPhoto() );

        return studentVO;
    }

    @Override
    public List<StudentVO> toVO(List<Student> list) {
        if ( list == null ) {
            return null;
        }

        List<StudentVO> list1 = new ArrayList<StudentVO>( list.size() );
        for ( Student student : list ) {
            list1.add( toVO( student ) );
        }

        return list1;
    }
}
