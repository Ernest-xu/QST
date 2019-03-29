package Ernest.until;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream; 
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

/**
 * 图片base64互转 
 * Created by yangyan on 2015/8/11.
 */ 
public class ImageBase64Utils {
	public static String whitepaperImg ="iVBORw0KGgoAAAANSUhEUgAAAmIAAAHMCAYAAAB2qMTlAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTExIDc5LjE1ODMyNSwgMjAxNS8wOS8xMC0wMToxMDoyMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjMxMDhFQjQ5RUUyNTExRThCNTc4RTFBMzNCODc0QTI5IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjMxMDhFQjRBRUUyNTExRThCNTc4RTFBMzNCODc0QTI5Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MzEwOEVCNDdFRTI1MTFFOEI1NzhFMUEzM0I4NzRBMjkiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6MzEwOEVCNDhFRTI1MTFFOEI1NzhFMUEzM0I4NzRBMjkiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5R1QkLAAAIA0lEQVR42uzcwUpUYRzG4ZmRdOUNpCDo3EEr72JE7SoCyUWSFxClmzZdhZJ2H0XQWkEhcR8t8sRwer88ggyKLZyvzfPAq+Mwq//qx8xgv23b3h1ms1G31exp9xwAAA/7mX3PvmZH2aesmXxR/44QW8v2sqEbAgA8ipNsJ/t4X4jNZG+yV24FADAV5c2u3Ww8GWLvRBgAQJUY27kdYhvZgbsAAFSxmR2WECtfwj/NFt0EAKCKi2x50BWZCAMAqGche15CbOQWAADVjcpHk2d5sOQWAABVnZcQ+5UHc24BAFBVU0KsdQcAgPqEGACAEAMAEGIAAAgxAAAhBgCAEAMAEGIAAAgxAAAhBgCAEAMAEGIAAAgxAAAhBgAgxIQYAIAQAwAQYgAACDEAACEGAIAQAwAQYgAACDEAACEGAIAQAwAQYgAACDEAACEGACDEhBgAgBADABBiAAAIMQAAIQYAgBADABBiAAAIMQAAIQYAgBADABBiAAAIMQAAIQYAIMSEGACAEAMAEGIAAAgxAAAhBgCAEAMAEGIAAAgxAAAhBgCAEAMAEGIAAAgxAAAhBgAgxIQYAIAQAwAQYgAACDEAACEGAIAQAwAQYgAACDEAACEGAIAQAwAQYgAACDEAACEGACDEnAEAQIgBAAgxAACEGACAEAMAQIgBAAgxAACEGACAEAMAQIgBAAgxAACEGACAEAMAEGIAAAgxAAAhBgCAEAMAEGIAAAgxAAAhBgCAEAMAEGIAAAgxAAAhBgCAEAMAEGIAAEIMAAAhBgAgxAAAEGIAAEIMAAAhBgAgxAAAEGIAAEIMAAAhBgAgxAAAEGIAAEIMAECIAQAgxAAAhBgAAEIMAECIAQAgxAAAhBgAAEIMAECIAQAgxAAAhBgAAEIMAECIAQAIMQAAhBgAgBADAECIAQAIMQAAhBgAgBADAECIAQAIMQAAhBgAgBADAECIAQAIMQAAIQYAgBADABBiAAAIMQAAIQYAgBADABBiAAAIMQAAIQYAgBADABBiAAAIMQAAIQYAIMQAABBiAABCDAAAIQYAIMQAABBiAABCDAAAIQYAIMQAABBiAABCDAAAIQYAIMQAAIQYAABCDABAiAEAIMQAAIQYAABCDABAiAEAIMQAAIQYAABCDABAiAEAIMQAAIQYAIAQAwBAiAEACDEAAIQYAIAQAwBAiAEACDEAAIQYAIAQAwBAiAEACDEAAIQYAIAQAwAQYgAACDEAACEGAIAQAwAQYgAACDEAACEGAIAQAwAQYgAACDEAACEGAIAQAwAQYgAAQgwAACEGACDEAAAQYgAAQgwAACEGACDEAAAQYgAAQgwAACEGACDEAAAQYgAAQgwAQIgBACDEAACEGAAAQgwAQIgBACDEAACEGAAAQgwAQIgBACDEAACEGAAAQgwAQIgBAAgxAACEGACAEAMAQIgBAAgxAACEGACAEAMAQIgBAAgxAACEGACAEAMAQIgBAAgxAAAhBgCAEAMAEGIAAAgxAAAhBgCAEAMAEGIAAAgxAAAhBgCAEAMAEGIAAAgxAAAhBgAgxAAAEGIAAEIMAAAhBgAgxAAAEGIAAEIMAAAhBgAgxAAAEGIAAEIMAAAhBgAgxAAAhBgAAEIMAECIAQAgxAAAhBgAAEIMAECIAQAgxAAAhBgAAEIMAECIAQAIMSEGACDEAACEGAAAQgwAQIgBACDEAACEGAAAQgwAQIgBACDEAACEGAAAQgwAQIgBAAgxIQYAIMQAAIQYAABCDABAiAEAIMQAAIQYAABCDABAiAEAIMQAAIQYAABCDABAiAEACDEhBgAgxAAAhBgAAEIMAECIAQAgxAAAhBgAAEIMAECIAQAgxAAAhBgAAEIMAECIAQAIMSEGACDEAACEGAAAQgwAQIgBACDEAACEGAAAQgwAQIgBACDEAACEGAAAQgwAQIgBAAgxZwAAEGIAAEIMAAAhBgAgxAAAEGIAAEIMAAAhBgAgxAAAEGIAAEIMAAAhBgAgxAAAhBgAAEIMAECIAQAgxAAAhBgAAEIMAECIAQAgxAAAhBgAAEIMAECIAQAgxAAAhBgAgBADAECIAQAIMQAAhBgAgBADAECIAQAIMQAAhBgAgBADAECIAQAIMQAAhBgAgBADABBiAAAIMQAAIQYAgBADABBiAAAIMQAAIQYAgBADABBiAAAIMQAAIQYAgBADABBiAABCDAAAIQYAIMQAABBiAABCDAAAIQYAIMQAABBiAABCDAAAIQYAIMQAABBiAABCDABAiAEAIMQAAIQYAABCDABAiAEAIMQAAIQYAABCDABAiAEAIMQAAIQYAABCDABAiAEACDEAAIQYAIAQAwBAiAEACDEAAIQYAIAQAwBAiAEACDEAAIQYAIAQAwBAiAEACDEAACEGAIAQAwAQYgAACDEAACEGAIAQAwAQYgAACDEAACEGAIAQAwAQYgAACDEAACEGACDEAAAQYgAAQgwAACEGACDEAAAQYgAAQgwAACEGACDEAAAQYgAAQgwAACEGAPDfQ+xHfs87BQBAVc0gPy7dAQCgussSYt/cAQCgus8lxI7dAQCguuPyHbHZPDjNFt0DAKCKi2ylvCPWZNvuAQBQzcvsatD9cZDtuwkAwNTtd+31999X3Dw5k73PXrgPAMBUfMi2svFkiN1Yz95mQ7cCAHgUJ9nr7PD2k/17/rF++QL/ZraWPcsWsiduCADwT373rr+Q/yU76l1/FNlMvuiPAAMA9ZwzpZRIZ2IAAAAASUVORK5CYII=";
	
	public static String getPath(String Type){
		String docStorePath = "";
		if("img".equals(Type)){
			docStorePath = "D:\\ImageUpLoad\\";
		}else if("excel".equals(Type)){
			docStorePath = "D:\\ExcelUpLoad\\";
		}
		return docStorePath;
	}
	public static String getUrl(String Type){
		String Url = "";
		if("img".equals(Type)){
			Url = "/file/";
		}else if("excel".equals(Type)){
			Url = "/excel/";
		}
		return Url;
	}
	
	public static byte[] base64String2ByteFun(String base64Str){
		return Base64.decodeBase64(base64Str);
	};
	
    public static String bytesToBase64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);// 返回Base64编码过的字节数组字符串
    }

    /**
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     *
     * @param path 图片路径
     * @return base64字符串
     */
    public static String imageToBase64(String path) throws IOException {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        // 读取图片字节数组
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Base64.encodeBase64String(data);// 返回Base64编码过的字节数组字符串
    }

    /**
     * 处理Base64解码并写图片到指定位置
     *
     * @param base64 图片Base64数据
     * @param path   图片保存路径
     * @return
     */
    public static boolean base64ToImageFile(String base64, String path) throws IOException {// 对字节数组字符串进行Base64解码并生成图片
        // 生成jpeg图片
        try {
            OutputStream out = new FileOutputStream(path);
            return base64ToImageOutput(base64, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 处理Base64解码并输出流
     *
     * @param base64
     * @param out
     * @return
     */
    public static boolean base64ToImageOutput(String base64, OutputStream out) throws IOException {
        if (base64 == null) { // 图像数据为空
            return false;
        }
        try {
            // Base64解码
            byte[] bytes = Base64.decodeBase64(base64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            out.write(bytes);
            out.flush();
            return true;
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
}
