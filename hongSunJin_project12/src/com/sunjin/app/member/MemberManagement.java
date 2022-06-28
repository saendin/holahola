package com.sunjin.app.member;

import java.util.Scanner;

import com.sunjin.app.common.LogInSys;
import com.sunjin.app.common.Login;

public class MemberManagement extends LogInSys {
	private Scanner sc = new Scanner(System.in);
	protected MemberDAO mDAO = MemberDAO.getInstance();

	// LogInSys 후 권한에 따라 프로그램 실행
	public void run() {
		// 메뉴에 따라 프로그램 실행 시키도록.
		// 권한이 0일 때 관리자시스템 실행
		boolean role = selectRole();

		while (true) {
			// 메뉴 출력 - 제품 정보 관리/ 제품 재고 관리/ 종료
			menuPrint(role);

			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 회원 정보 조회
				memberInfo();
			} else if (menuNo == 2) {
				// 회원 정보 수정
				updateInfoP();
			} else if (menuNo == 3) {
				// 주문 내역
				orderList();
			} else if (menuNo == 9) {
				//
				deleteMember();
			} else if (menuNo == 0) {
				// 뒤로
				break;
			} else {
				// 입력 오류
				showInputError();
			}
		}
	}

	private void memberInfo() {
		String member = Login.getLogin().getId();
		System.out.println(member);
	}

	private void orderList() {
		// TODO Auto-generated method stub
	}

	private void menuPrint(boolean role) {
		// 권한에 따라 메뉴를 프린트하기 위한 것
		if (!role) {
			String menu1 = "";
			// 회원[1]권한
			menu1 += "1 회원정보 | 2 회원정보수정 | 3 주문내역 | 9 회원탈퇴  | 0 뒤로가기";
			System.out.println();
			System.out.println(
					"======================================      메뉴      ========================================");
			System.out.println();
			System.out.println("                     " + menu1);
			System.out.println();
			System.out.println(
					"=============================================================================================");
		} else {
			String menu2 = "";
			// 관리자[0]권한
			menu2 += "1 회원정보 | 9 회원삭제 | 0 뒤로가기";
			System.out.println(
					"======================================      관리      ========================================");
			System.out.println();
			System.out.println("                               " + menu2);
			System.out.println();
			System.out.println(
					"=============================================================================================");
		}
	}
	// 회원가입
//	private void insertMember() {
//		// 등록할 때 필요한 데이터 값 받기
//		Member member = inputMemberInfo();
//
//		mDAO.insert(member);
//	}

//	private Member inputMemberInfo() {
//		Member member = new Member();
//
//		System.out.println("아이디");
//		sc.nextLine();
//		member.setId(sc.nextLine());
//
//		System.out.println("비밀번호");
//		sc.nextLine();
//		member.setPwd(sc.nextLine());
//
//		System.out.println("이름");
//		Integer.parseInt(sc.nextLine());
//		member.setName(sc.nextLine());
//
//		System.out.println("이메일");
//		Integer.parseInt(sc.nextLine());
//		member.setName(sc.nextLine());
//
//		System.out.println("휴대폰 번호");
//		Integer.parseInt(sc.nextLine());
//		member.setPhone(Integer.parseInt(sc.nextLine()));
//
//		return member;
//	}

	// 수정
//	// 휴대폰 번호 수정할 아이디 입력받기
//	String id = inputId();
//	// 아이디 검색
//	Member member = mDAO.updateInfoP(id);
//
//	if(member!=null)
//	{
//		// id값이 없을경우 다음을 반환
//		inputUpdatePhone(member);
//		mDAO.updateInfoP(member.getId());
//	} // 변경할 id 값을 찾았을 경우 수정되도록
//	System.out.println("검색 결과가 없습니다!");
//	}
	// 회원 정보 수정 - phone num
	private void updateInfoP() {
		String member = Login.getLogin().getId();
		System.out.println(member);
		// 비번 다시 입력받기
		String pwd = inputPwd();
		while (true) {
			// 아이디랑 일치여부 확인
			if (pwd.equals(Login.getLogin().getPwd())) {
				inputUpdatePhone();
				mDAO.updateInfoP(member);
			} else {
				System.out.println();
				System.out.println("잘못된 비밀번호입니다.");
				System.out.println("다시한번 확인해주세요!");
				System.out.println();
				return;
			}
		}
	}

	private String inputPwd() {
		System.out.println();
		System.out.println("비밀번호를 한번 더 입력해주세요");
		return sc.nextLine();
	}

	private int inputUpdatePhone() {
		Member member = new Member();
		System.out.println();
		System.out.println("기존 전화번호 | " + member.getPhone());
		System.out.println();
		System.out.println("   수정할 전화번호를 입력해주세요 ");
		System.out.println(">>수정을 원하지 않을 경우 0 입력<<");
		System.out.println();
		int phoneNum = Integer.parseInt(sc.nextLine());
		if (phoneNum != 0) {
			member.setPhone(phoneNum);
		}
		return phoneNum;
	}

	// 회원 삭제
	private void deleteMember() {
		String id = inputId();
		// 품번 검색
		Member findId = mDAO.findId(id);

		if (findId == null) {
			// isn값이 없을경우 다음을 반환
			System.out.println("검색 결과가 없습니다!");
			return;
		}
		int answer = YesOrNo();
		if (answer == 1) {
			// yes(1) = 삭제
			mDAO.delete(findId.getId());
		} else if (answer == 0) {
			System.out.println("이제 다시 럭셔리 모먼트의 많은 혜택을 누리실 수 있어요!");
		}
	}

	private String inputId() {
		System.out.println("삭제할 아이디를 다시 한번 입력하세요");
		return sc.nextLine();
	}

	private int YesOrNo() {
		System.out.println("탈퇴하시면 더 이상 럭셔리모먼트의 혜탁을 받을 수 없습니다.");
		System.out.println("          그래도 계속 하시겠습니까?");
		System.out.println("         네: 1  |  돌아가기:  0");
		return Integer.parseInt(sc.nextLine());
	}
}
