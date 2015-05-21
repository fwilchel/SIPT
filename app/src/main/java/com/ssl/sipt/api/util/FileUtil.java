package com.ssl.sipt.api.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author d5a9p6s7
 */
public class FileUtil {

  private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

  /**
   *
   * @param is
   * @param path
   * @throws IOException
   */
  public static void createFile(InputStream is, String path) throws IOException {
    LOG.debug("method: createFile(is,path);");
    try (OutputStream fos = new FileOutputStream(path)) {
      IOUtils.copy(is, fos);
    } catch (IOException ex) {
      throw ex;
    }
  }

  /**
   *
   * @param is
   * @param file
   * @throws IOException
   */
  public static void createFile(InputStream is, File file) throws IOException {
    LOG.debug("method: createFile(is,file);");
    try (OutputStream fos = new FileOutputStream(file)) {
      IOUtils.copy(is, fos);
    } catch (IOException ex) {
      throw ex;
    }
  }

  /**
   *
   * @param is
   * @param path
   * @throws java.io.IOException
   */
  public static void updateFile(InputStream is, String path) throws IOException {
    LOG.debug("method: updateFile(resourceName);");
    try {
      deleteFile(path);
      createFile(is, path);
    } catch (IOException ex) {
      throw ex;
    }
  }

  /**
   *
   * @param path
   * @throws java.io.IOException
   */
  public static void deleteFile(String path) throws IOException {
    LOG.debug("method: deleteFile(resourceName);");
    if (path == null) {
      throw new IllegalArgumentException();
    }
    File file = new File(path);
    if (file.delete()) {
      LOG.debug("method: getPropertiesFromResources(resourceName); " + file.getName() + " is deleted!");
    } else {
      LOG.debug("method: getPropertiesFromResources(resourceName); Delete operation is failed.");
    }
  }

  /**
   *
   * @param what
   * @param with
   * @return
   */
  public static String getDefaultImageNameFile(String what, String with) {
    LOG.debug("method: getDefaultImageNameFile(what, with);");
    int index = what.lastIndexOf(".");
    return with.concat(what.substring(index));
  }

  /**
   *
   * @param path
   * @param name
   * @param content
   */
  public static void createFileFromString(String path, String name, String content) {
    LOG.debug("method: createFileFromString(path, name, content);");
    try (PrintWriter out = new PrintWriter(name)) {
      out.println(content);
    } catch (FileNotFoundException ex) {
      LOG.error("Error in method: createFileFromString()", ex);
    }
  }

  /**
   * @author Alejandro Poveda
   * @param inputStream
   * @return
   * @throws IOException
   */
  public static String inputStreamToBase64(InputStream inputStream) throws IOException {
    if (inputStream == null) {
      return null;
    }
    String base64 = new String(Base64.encodeBase64(IOUtils.toByteArray(inputStream)));
    return base64;
  }

  /**
   * @author Alejandro Poveda
   * @param base64
   * @return
   * @throws IOException
   */
  public static InputStream base64ToInputStream(String base64) throws IOException {
    if (base64 == null) {
      return null;
    }
    InputStream is = new ByteArrayInputStream(Base64.decodeBase64(base64.getBytes()));
    return is;
  }

  /**
   *
   * @param prefix
   * @param suffix
   * @return
   * @throws IOException
   */
  public static File createTempFile(String prefix, String suffix) throws IOException {
    LOG.info("Entro a: <<createTempFile>>");
    try {
      //create a temp file
      File temp = File.createTempFile(prefix, suffix);
      LOG.debug("Temp file : " + temp.getAbsolutePath());
      temp.deleteOnExit();
      return temp;
    } catch (IOException ex) {
      LOG.error("Error en <<createTempFile>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw ex;
    }

  }
}
