package com.yg.learn.config;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

@Component
public class MyHttpMessageConverter extends AbstractHttpMessageConverter<String> {



    @Override
    protected boolean supports(Class<?> clazz) {
        return Callable.class.isAssignableFrom(clazz);
    }

    @Override
    protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        System.out.println("abc111---------------");
        System.out.println("abc111---------------");
        return null;
    }

    @Override
    protected void writeInternal(String stringCallable, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("abc222---------------");
        System.out.println("abc222---------------");
    }
}
