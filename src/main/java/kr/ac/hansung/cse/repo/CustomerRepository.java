package kr.ac.hansung.cse.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import kr.ac.hansung.cse.model.Customer;

// CrudRepository : CRUD 기능 제공 (DAO 대신 사용)
public interface CustomerRepository extends CrudRepository<Customer, Long>{ // <클래스 이름, id의 타입>
	// CRUD 기능 + 아래 기능 추가
	// 아래 메소드의 구현 클래스 자동적으로 생성 됨! (개신기)
	List<Customer> findByLastName(String lastName);
}