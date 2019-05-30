package kr.ac.hansung.cse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootConfiguration, @EnableConfiguration, @ComponentScan 모두 포함
// @SpringBootConfiguration : Configuration (설정) class임을 명시
// @EnableConfiguration : 자동 설정 기능 활성화 (Auto Configuration)
// @ComponentScan : 클래스들을 모두 스캔 => bean으로 등록
@SpringBootApplication
public class HelloSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}

}
