package com.acdsg2.finalproj;

public class AirplaneType {
	static final int PrivateCapacity = 14, BusinessCapacity = 23, RegularFCapacity = 48;
	static final int Private = 1;
	static final int Business = 2;
	static final int RegularF = 3;
	static int[] seatNum = new int [PrivateCapacity+BusinessCapacity+RegularFCapacity];
	static boolean[] seatStatus = new boolean[PrivateCapacity+BusinessCapacity+RegularFCapacity];
	static int PrivateAvailable = PrivateCapacity;
	static int BusinessAvailable = BusinessCapacity;
	static int RegularFAvailable = RegularFCapacity;
	static int seatType = 0;
	static int seatNumber = 0;
}
