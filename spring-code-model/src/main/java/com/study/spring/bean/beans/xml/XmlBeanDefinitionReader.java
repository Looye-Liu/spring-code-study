package com.study.spring.bean.beans.xml;

import com.study.spring.bean.beans.AbstractBeanDefinitionReader;
import com.study.spring.bean.beans.BeanDefinition;
import com.study.spring.bean.beans.BeanReference;
import com.study.spring.bean.beans.PropertyValue;
import com.study.spring.bean.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by looye on 2019/3/6.
 *
 * @author looye
 * @date 2019/3/6
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinition(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        //解析xml，加载类，初始化配置信息
        doLoadBeanDefinitions(inputStream);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        registerBeanDefinitions(document);
        inputStream.close();
    }

    protected void registerBeanDefinitions(Document document) {
        Element element = document.getDocumentElement();
        parseBeanDefinitions(element);
    }

    protected void parseBeanDefinitions(Element root) {
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                parseBeanDefinition(element);
            }
        }
    }

    protected void parseBeanDefinition(Element element) {
        String name = element.getAttribute("id");
        String className = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
        processProperty(element, beanDefinition);
    }

    protected void processProperty(Element element, BeanDefinition beanDefinition) {
        NodeList nodeList = element.getElementsByTagName("property");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element property = (Element) node;
                String name = property.getAttribute("name");
                String value = property.getAttribute("value");
                if (null != value && value.length() > 0) {
                    beanDefinition.getPropertyValues().add(new PropertyValue(name, value));
                } else {
                    String ref = property.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }
                    BeanReference reference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().add(new PropertyValue(name, reference));
                }
            }
        }
    }
}
