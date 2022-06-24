package com.sunjin.app.member;

import java.util.Scanner;

import com.sunjin.app.common.Login;
import com.sunjin.app.product.Product;

public class MemberManagement extends Login {
	private Scanner sc = new Scanner(System.in);

	// 회원가입
	private void insertMember() {
		// 등록할 때 필요한 데이터 값 받기
		Member member = inputMemberInfo();

		mDAO.insert(member);
	}

	private Member inputMemberInfo() {
		Member member = new Member();

		System.out.println("아이디");
		sc.nextLine();
		member.setId(sc.nextLine());

		System.out.println("비밀번호");
		sc.nextLine();
		member.setPwd(sc.nextLine());

		System.out.println("이름");
		Integer.parseInt(sc.nextLine());
		member.setName(sc.nextLine());

		System.out.println("이메일");
		Integer.parseInt(sc.nextLine());
		member.setName(sc.nextLine());

		System.out.println("휴대폰 번호");
		Integer.parseInt(sc.nextLine());
		member.setPhone(Integer.parseInt(sc.nextLine()));

		return member;
	}

	private void updateInfoP() {

		// 휴대폰 번호 수정할 아이디 입력받기
		String id = inputId();
		// 아이디 검색
		Member member = mDAO.updateInfoP(id);

		if (member == null) {
			// id값이 없을경우 다음을 반환
			System.out.println("검색 결과가 없습니다!");
		} // 변경할 id 값을 찾았을 경우 수정되도록
		member = inputUpdatePhone(member);

		mDAO.updateInfoP(member);
	}

	private String inputId() {
		System.out.println("수정할 아이디를 다시 한번 입력하세요");
		return sc.nextLine();
	}

	private Member inputUpdatePhone(Member member) {
		System.out.println("기존 전화번호 " + member.getPhone());
		System.out.println("수정할 전화번호를 입력해주세요 ");
		System.out.println(">>수정을 원하지 않을 경우 0 입력<<");
		// 수정을 원하지 않을 경우 원래 가격 반환
		int phone = Integer.parseInt(sc.nextLine());

		if (phone > 0) {
			member.setPhone(phone);
		}
		return phone;
	}

//	private void deleteProduct() {
//		int isn = inputIsn();
//		// 품번 검색
//		Product findisn = proDAO.findIsn(isn);
//
//		if (findisn == null) {
//			// isn값이 없을경우 다음을 반환
//			System.out.println("검색 결과가 없습니다!");
//			return;
//		} // 대여 내역이 있을 시 삭제할지 확인
//		boolean stockInExist = sInDAO.selectedInfo(findisn.getIsn());
//
//		if (stockInExist) {
//			System.out.println("상품의 재고가 존재합니다.");
//			// scanner로 여부 물어보고 실행
//			int answer = YesOrNo();
//			if (answer == 1) {
//				// yes(1) = 삭제
//				proDAO.delete(findisn.getPrice());
//			} else if (answer == 0) {
//				System.out.println("수정이 취소되었습니다");
//			}
//		}
//
//	}

	private int YesOrNo() {
		System.out.println("그래도 삭제하시겠습니까?");
		System.out.println("네: 1  |  돌아가기:  0");
		return Integer.parseInt(sc.nextLine());
	}
}
