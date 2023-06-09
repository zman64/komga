CREATE TABLE THUMBNAIL_COLLECTION
(
    ID                 varchar  NOT NULL PRIMARY KEY,
    SELECTED           boolean  NOT NULL DEFAULT 0,
    THUMBNAIL          blob     NOT NULL,
    TYPE               varchar  NOT NULL,
    COLLECTION_ID      varchar  NOT NULL,
    CREATED_DATE       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    LAST_MODIFIED_DATE datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (COLLECTION_ID) REFERENCES COLLECTION (ID)
);

CREATE TABLE THUMBNAIL_READLIST
(
    ID                 varchar  NOT NULL PRIMARY KEY,
    SELECTED           boolean  NOT NULL DEFAULT 0,
    THUMBNAIL          blob     NOT NULL,
    TYPE               varchar  NOT NULL,
    READLIST_ID        varchar  NOT NULL,
    CREATED_DATE       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    LAST_MODIFIED_DATE datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (READLIST_ID) REFERENCES READLIST (ID)
);
