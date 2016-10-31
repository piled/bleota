import java.io.*;

class createHeader {
    public static void main(String[] argv) throws Exception {
        FileOutputStream out = new FileOutputStream("header.bin");
        byte[] magic = {'S', 'L', 'O', 'T'};
        out.write(magic);
        out.write(1);
        out.write(0); //seq #
        out.write(0x00);
        out.write(0x80); //  code size
        out.write(0x00);
        out.write(0x80); //
        out.write(0x00);
        out.write(0x00); // start address
        out.write(0x00);
        out.write(0x00); //
        out.write(0x00);
        out.write(0x00); // crc
        String description = "First app";
        out.write(description.getBytes());
        out.flush();
        out.close();
    }
}

