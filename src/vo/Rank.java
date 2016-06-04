package vo;

public class Rank implements Comparable<Rank> {
	private String phone;
	private String nickname;
	private int total;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	// 倒序
	@Override
	public int compareTo(Rank rank) {
		// TODO Auto-generated method stub
		if (this.total > rank.total) {
			return -1;
		} else if (this.total < rank.total) {
			return 1;
		} else {
			return 0;
		}
	}

}
