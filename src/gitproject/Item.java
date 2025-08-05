package gitproject;
/**
 * 商品クラス
 */
import java.util.Date;

public class Item {
	String title;
	int price;
	Date releaseDate;

	Item(String title, int price, Date releaseDate) {
		this.title = title;
		this.price = price;
		this.releaseDate = releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}
