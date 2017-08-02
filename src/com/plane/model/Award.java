package com.plane.model;

import com.plane.util.Contants;

public interface Award {
	public int double_fire=Contants.AWARD_DOUBLE_FIRE;//双倍活力
	public int life=Contants.AWARD_LIFE;//一条命
	//获取奖励类型   0  /  1
	int getType();
	
}
