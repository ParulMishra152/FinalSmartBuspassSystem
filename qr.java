import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class qr {
    String objtoStr;
    String id;
    qr(String id)
    {   
        this.id=id;
        objtoStr= new tripcount(id).toString();
        String strtovalue= String.valueOf(new tripcount(id));
        try
        {
           File filename= new File("C:\\Users\\Parul Mishra\\Desktop\\qr.png");
           ByteArrayOutputStream out=QRCode.from(strtovalue).to(ImageType.PNG).stream();
           FileOutputStream fos=new FileOutputStream(filename);
           fos.write(out.toByteArray());
           fos.close();
           System.out.println("success");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
       new qr("");
    }

}
