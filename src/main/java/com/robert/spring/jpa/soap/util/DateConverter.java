package com.robert.spring.jpa.soap.util;

import org.dozer.DozerConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.invoke.MethodHandles;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Roberto Noriega
 * @version 1.0.0
 * @since 25/10/17
 **/
public final class DateConverter extends DozerConverter<Date, XMLGregorianCalendar> implements java.io.Serializable {

    private static final long serialVersionUID = 5428869173396130366L;

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public DateConverter() {
        super(Date.class, XMLGregorianCalendar.class);
    }

    @Override
    public XMLGregorianCalendar convertTo(Date source, XMLGregorianCalendar destination) {
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(source);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            LOGGER.error("{}", ex.getMessage());
        }

        return xmlCalendar;
    }

    @Override
    public Date convertFrom(XMLGregorianCalendar source, Date destination) {
        if (source == null) {
            return null;
        }

        return source.toGregorianCalendar().getTime();
    }

}