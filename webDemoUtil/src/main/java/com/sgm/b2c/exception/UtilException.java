package com.sgm.b2c.exception;


import java.io.Serializable;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/16.
 */
public class UtilException extends RuntimeException implements Serializable{
      public UtilException(){}

      public UtilException(Exception e){
          super(e);
      }

      public UtilException(String description,Exception e){
          super(description,e);
      }
}
