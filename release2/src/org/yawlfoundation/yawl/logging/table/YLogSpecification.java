package org.yawlfoundation.yawl.logging.table;

import org.yawlfoundation.yawl.elements.YSpecVersion;
import org.yawlfoundation.yawl.engine.YSpecificationID;
import org.yawlfoundation.yawl.util.StringUtil;

/**
 * One row of the logSpecification table, represents a unique specification.
 *
 * Note that even though specID + version is unique across all rows, field 'key' was used
 * because it greatly simplifies hibernate accesses to have a PK is not composite
 *
 * Author: Michael Adams
 * Creation Date: 6/04/2009
 */
public class YLogSpecification {

    private long rowKey;                                          // PK - auto generated
    private String identifier;                                    // UUID
    private String version ;
    private String uri;
    private long rootNetID;                                       // FK of YLogNet

    public YLogSpecification() { }

    public YLogSpecification(String identifier, YSpecVersion version, String uri,
                             long rootNetID) {
        this.identifier = identifier;
        this.version = version.getVersion();
        this.uri = uri;
        this.rootNetID = rootNetID;
    }

    public YLogSpecification(YSpecificationID ySpecID) {
        identifier = ySpecID.getIdentifier();
        version = ySpecID.getVersionAsString();
        uri = ySpecID.getUri();
        rootNetID = -1;
    }

    public long getRowKey() {
        return rowKey;
    }

    public void setRowKey(long rowKey) {
        this.rowKey = rowKey;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getRootNetID() {
        return rootNetID;
    }

    public void setRootNetID(long rootNetID) {
        this.rootNetID = rootNetID;
    }


    public String toXML() {
        StringBuilder xml = new StringBuilder(210);
        xml.append(String.format("<specification key=\"%d\">", rowKey));
        xml.append("<id>");
        xml.append(StringUtil.wrap(identifier, "identifier"));
        xml.append(StringUtil.wrap(version, "version"));
        xml.append(StringUtil.wrap(uri, "uri"));
        xml.append("</id>");
        xml.append(StringUtil.wrap(String.valueOf(rootNetID), "rootnetkey"));
        xml.append("</specification>");
        return xml.toString();
    }

}
