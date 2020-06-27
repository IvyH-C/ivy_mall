package com.mall.ivy.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
public class EmailUtil {

    /**
     * 发邮件
     * @param emailTo
     * @param headSubject
     * @param emailText
     * @return
     */
      public static String sendEmail(String emailTo, String headSubject, String emailText) {
          // 收件人电子邮箱，什么邮箱都可以
          String to = emailTo;

          // 发件人电子邮箱（固定）
          String from = "3607134159@qq.com";

          // 指定发送邮件的主机，我的为QQ邮箱，所以是QQ邮箱服务器的主机 smtp.qq.com（如果你是163的就上网百度163对应的邮箱服务器地址），如果是在本地开发，可能你本机解析不了这个域名，那么直接把它换成对应的ip地址就可以了，不知道对应的ip地址是多少就去ping一下
          String host = "smtp.qq.com";  //（根据固定邮箱的类型设置主机，也是固定设置）

          // 获取系统属性
          Properties properties = System.getProperties();

          // 设置邮件服务器
          properties.setProperty("mail.smtp.host", host);
          properties.put("mail.smtp.auth", true);


          // 获取默认session对象
          Session session = Session.getDefaultInstance(properties, new Authenticator() {
              @Override
              protected PasswordAuthentication getPasswordAuthentication() {
                  //EMAIL_AUTH_CODE为你用于发送邮件的邮箱对应的授权码，获取授权码的方法见底部
                  return new PasswordAuthentication("3607134159@qq.com", "ekwtxulqeomccjhh");
              }
          });

          try {
              // 创建默认的 MimeMessage 对象
              MimeMessage message = new MimeMessage(session);

              // Set From: 头部头字段
              message.setFrom(new InternetAddress(from));

              // Set To: 头部头字段
              message.addRecipient(Message.RecipientType.TO,
                      new InternetAddress(to));

              // Set Subject: 头部头字段
              message.setSubject(headSubject);

              // 设置消息体
              message.setText(emailText);

              // 发送消息
              Transport.send(message);
              System.out.println("Sent message successfully....");
          } catch (MessagingException mex) {
              mex.printStackTrace();
          }
          return null;
      }


    /**
     * 生成随机验证码
     * @return
     */
    public static String getVerifyCode(int length){  // length用来指定验证码的长度
         String str ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
         Random random = new Random();
         StringBuffer sb = new StringBuffer();
         for(int i = 0; i<length; i++){
            int num = random.nextInt(62); //62指的是随机数str范围的上限，随机产生的数是0-62（不包括62，因为下标是0开始）
            sb.append(str.charAt(num)); //由随机产生的num作为参数传入，得到str中对应的随机数。
        }
         return sb.toString();
      }

    /**
     * 发送验证邮件
     * @param toEmail
     * @return
     */
    public static String sendVerifyEmail(String toEmail){
        String code = getVerifyCode(4); //4位数随机验证码
        sendEmail(toEmail,"来自ivy_mall的验证邮件", "你的验证码是："+code+" 请尽快进行验证");
        return null;
    }





      }



