/*
 * Copyright 2004-2005 the original author or authors.
 */
package org.springframework.binding.format;

/**
 * Source for formatters - formatters are typically NOT thread safe, because
 * *Format objects generally aren't thread safe: so implementations of this
 * service should take care to synchronize them or ensure one instance per
 * thread.
 * @author Keith Donald
 */
public interface FormatterLocator {

	/**
	 * Returns a date formatter for the encoded date format
	 * @param encodedFormat the format
	 * @return the formatter
	 */
	public DateFormatter getDateFormatter(String encodedFormat);

	/**
	 * Returns the default date format for the current locale
	 * @return the date formatter
	 */
	public DateFormatter getDateFormatter();

	/**
	 * Returns the date format with the specified style for the current locale.
	 * @param style the style
	 * @return the formatter
	 */
	public DateFormatter getDateFormatter(Style style);

	/**
	 * Returns the default date/time format for the current locale
	 * @return the date/time formatter
	 */
	public DateFormatter getDateTimeFormatter();

	/**
	 * Returns the date format with the specified styles for the current locale.
	 * @param dateStyle the date style
	 * @param timeStyle the time style
	 * @return the formatter
	 */
	public DateFormatter getDateTimeFormatter(Style dateStyle, Style timeStyle);

	/**
	 * Returns the default time format for the current locale
	 * @return the time formatter
	 */
	public DateFormatter getTimeFormatter();

	/**
	 * Returns the time format with the specified style for the current locale.
	 * @param style the style
	 * @return the formatter
	 */
	public DateFormatter getTimeFormatter(Style style);

	/**
	 * Returns a number formatter for the specified class.
	 * @param numberClass the number class
	 * @return the number formatter
	 */
	public NumberFormatter getNumberFormatter(Class numberClass);

	/**
	 * Returns a percent number formatter
	 * @return the percent formatter
	 */
	public NumberFormatter getPercentFormatter();

	/**
	 * Returns a currency number formatter
	 * @return the currency formatter
	 */
	public NumberFormatter getCurrencyFormatter();
}