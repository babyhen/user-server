package com.pawpaw.fishinghome.usercenter.dao.entity;

public class UserAccountEnum {

	public enum Gender {
		MALE(1), FEMALE(2);
		int value;

		Gender(int value) {
			this.value = value;
		}

		public int intValue() {
			return this.value;
		}

		public static Gender fromIntValue(int value) {
			for(Gender g:Gender.values()) {
				if(g.value==value) {
					return g;
				}
			}
			throw new RuntimeException("非法的gender值");
		}
	}

	public enum Source {
		PAWPAW(1), WEIXIN(2);
		int value;

		Source(int value) {
			this.value = value;
		}

		public int intValue() {
			return this.value;
		}
	}

	public enum Status {
		NORMAL(1), DELETE(2);
		int value;

		Status(int value) {
			this.value = value;
		}

		public int intValue() {
			return this.value;
		}
	}

	public enum Type {
		NORMAL(1), VIRTUAL(2);
		int value;

		Type(int value) {
			this.value = value;
		}

		public int intValue() {
			return this.value;
		}
	}
}