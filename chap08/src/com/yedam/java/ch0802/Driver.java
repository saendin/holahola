package com.yedam.java.ch0802;

public class Driver {
	//자동차를 운전할 수 있는 방법을 알고 있음.
	void drive(Vehicle vehicle) {
		//이 사람이 운전할때 탈것이 택시인지 버스인지 확인하라
		if(vehicle instanceof Bus) {
			//():캐스트를 사용하면 강제로 바꿔줬다는거기 때문에 instanceOf를 써서 확인해줘라
			Bus bus = (Bus)vehicle;
			bus.checkFare();
		}
		vehicle.run();
	}
}
