package com.yedam.java.emp;
import java.util.List;


public class MainTest {

	public static void main(String[] args) {
		List<Employee> list = EmpDAO.getInstance().selectAll();
		for(Employee emp : list) {
			System.out.println(emp);
		}
	}

}


/*
 * 사원조회
 * 사원삭제
 * DAO로 할 수 있는게 뭐가 있을지 생각해보기
 */
