/**
 * 
 */
package Ernest.until;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**随机摇头像
 * @author Ernest
 *
 */
public class Head {

	public static String  getRandomImage(){
		String img1="/x5/UI2/BZB01/common/image/img1.jpg",
				img2="/x5/UI2/BZB01/common/image/img2.jpg",
				img3="/x5/UI2/BZB01/common/image/img3.jpg",
				img4="/x5/UI2/BZB01/common/image/img4.jpg",
				img5="/x5/UI2/BZB01/common/image/img5.jpg",
				img6="/x5/UI2/BZB01/common/image/img6.jpg";
		List<String> imgList=new ArrayList<String>();
		imgList.add(img6);
		imgList.add(img5);
		imgList.add(img4);
		imgList.add(img3);
		imgList.add(img2);
		imgList.add(img1);
		String fImage=imgList.get(new Random().nextInt(5)+1);
		return fImage;
	}
}
