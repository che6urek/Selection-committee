package com.by.evgeny.selection.committee.parser;

import com.by.evgeny.selection.committee.exceptions.DataSourceException;

import java.util.List;

public interface XmlParser<T> {

    List<T> getDataFromFile(String filePath) throws DataSourceException;
}
