package com.ju1cer.dicktionary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;

public class FileHelper {

    private Context mContext;

    public FileHelper() {
    }

    public FileHelper(Context mContext) {
        super();
        this.mContext = mContext;
    }

    /*
    * ���ﶨ�����һ���ļ�����ķ�����д�뵽�ļ��У������������
    * */
    public void save(String filename, String filecontent) throws Exception {
        //��������ʹ��˽��ģʽ,�����������ļ�ֻ�ܱ���Ӧ�÷���,���Ḳ��ԭ�ļ�Ŷ
        FileOutputStream output = mContext.openFileOutput(filename, Context.MODE_PRIVATE);
        output.write(filecontent.getBytes());  //��String�ַ������ֽ�������ʽд�뵽�������
        output.close();         //�ر������
    }


    /*
    * ���ﶨ������ļ���ȡ�ķ���
    * */
    public String read(String filename) throws IOException {
        //���ļ�������
        FileInputStream input = mContext.openFileInput(filename);
        byte[] temp = new byte[1024];
        StringBuilder sb = new StringBuilder("");
        int len = 0;
        //��ȡ�ļ�����:
        while ((len = input.read(temp)) > 0) {
            sb.append(new String(temp, 0, len));
        }
        //�ر�������
        input.close();
        return sb.toString();
    }

}