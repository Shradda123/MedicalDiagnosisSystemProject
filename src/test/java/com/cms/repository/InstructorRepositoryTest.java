package com.cms.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Negative;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.cms.entity.Instructor;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InstructorRepositoryTest {

	@Autowired
	private InstructorRepository instructorRepository;

	@Test
    @Rollback(value = false)
	@Order(1)
	void saveInstructorTest()
	{
		Instructor instructor3=new Instructor();
		instructor3.setFirstName("joy");
		instructor3.setLastName("poddar");
		instructor3.setEmail("joy.p@gmail.com");
		
		
		instructorRepository.save(instructor3);
		assertThat(instructor3.getUserId()).isGreaterThan(0);
		//assertEquals(1, instructor.getUserId());
	}

	@Test
	@Rollback(value = false)
	@Order(3)
	void getAllInstructorTest()
	{
	List<Instructor> list=instructorRepository.findAll();
	assertThat(list.size()).isGreaterThan(1);
	}
	
	
	@Test
	@Rollback(value = false)
	@Order(2)
	void updateInstructorTest()
	{
	Instructor updateIns=instructorRepository.findById(3).get();
	updateIns.setFirstName("anurag");
	Instructor ins=instructorRepository.save(updateIns);
	assertThat(ins.getFirstName()).isEqualTo("anurag");
	}
	
	@Test
	@Rollback(value = false)
	@DisplayName("negative test case")
	@Order(4)
	void deleteInstructorTest()
	{
	Instructor ins=instructorRepository.findById(4).get();
	instructorRepository.delete(ins);
	
	Instructor instructor=null;
Optional<Instructor> opIns=instructorRepository.findByFirstName("joy");
if(opIns.isPresent())
{

	instructor=opIns.get();
}

assertThat(instructor).isNull();
	}
}
