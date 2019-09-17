package com.test.exception;

import java.io.IOException;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

//ȫ���쳣������
@ControllerAdvice(basePackages= {"com.test.controller"})
public class GlobalExceptionResolver {
	
	//��ָ���쳣
    @ExceptionHandler(NullPointerException.class)  
    public String nullPointerExceptionHandler(NullPointerException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "��ָ���쳣");
        return "dynamicError";
    }   
	//����ʱ�쳣
    @ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR,reason="����ʱ�쳣")
    @ExceptionHandler(RuntimeException.class)  
    public String runtimeExceptionHandler(RuntimeException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "����ʱ�쳣");
        return "dynamicError";
    }  
    //����ת���쳣
    @ExceptionHandler(ClassCastException.class)  
    public String classCastExceptionHandler(ClassCastException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "����ת���쳣");
        return "dynamicError"; 
    }  

    //IO�쳣
    @ExceptionHandler(IOException.class)  
    public String iOExceptionHandler(IOException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "IO�쳣");
        return "dynamicError"; 
    }  
    //δ֪�����쳣
    @ExceptionHandler(NoSuchMethodException.class)  
    public String noSuchMethodExceptionHandler(NoSuchMethodException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "δ֪�����쳣");
        return "dynamicError"; 
    }  
    //����Խ���쳣
    @ExceptionHandler(IndexOutOfBoundsException.class)  
    public String indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "����Խ���쳣");
        return "dynamicError"; 
    }
	//�Ƿ������쳣
    @ExceptionHandler(IllegalArgumentException.class)
    public String IllegalArgumentExceptionR(IllegalArgumentException ex,Model model){
    	 model.addAttribute("errorCode", "");
         model.addAttribute("msg", "�쳣����");
         return "dynamicError"; 
    }
    //400����
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String requestNotReadable(HttpMessageNotReadableException ex,Model model){
        ex.printStackTrace();
        model.addAttribute("errorCode", "400");
        model.addAttribute("msg", "400����");
        return "dynamicError"; 
    }
    //400����
    @ExceptionHandler({TypeMismatchException.class})
    public String requestTypeMismatch(TypeMismatchException ex,Model model){
        ex.printStackTrace();
        model.addAttribute("errorCode", "400");
        model.addAttribute("msg", "400����");
        return "dynamicError"; 
    }
    //400����
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public String requestMissingServletRequest(MissingServletRequestParameterException ex,Model model){
        ex.printStackTrace();
        model.addAttribute("errorCode", "400");
        model.addAttribute("msg", "400����");
        return "dynamicError"; 
    }
    //404����
    @ExceptionHandler({NoHandlerFoundException.class})
    public String noHandlerFoundExceptionR(NoHandlerFoundException ex,Model model){
        ex.printStackTrace();
        model.addAttribute("errorCode", "404");
        model.addAttribute("msg", "404����");
        return "dynamicError"; 
    }
    //405����
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public String request405(Model model,HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException){
    	 model.addAttribute("errorCode", "405");
         model.addAttribute("msg", "405����");
         return "dynamicError"; 
    }
    //406����
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public String request406(Model model,HttpMediaTypeNotAcceptableException httpMediaTypeNotAcceptableException){
    	 model.addAttribute("errorCode", "406");
         model.addAttribute("msg", "406����");
         return "dynamicError"; 
    }
    //500����
    @ExceptionHandler({ConversionNotSupportedException.class,HttpMessageNotWritableException.class})
    public String server500(RuntimeException runtimeException,Model model){
    	 model.addAttribute("errorCode", "500");
         model.addAttribute("msg", "500����");
         return "dynamicError"; 
    }
	//�����쳣ͳһ����
    @ExceptionHandler(Exception.class)
    public String handleOtherException(Exception ex,Model model){
    	 model.addAttribute("errorCode", "");
         model.addAttribute("msg", "δ֪����");
         return "dynamicError"; 
    }

    
}
