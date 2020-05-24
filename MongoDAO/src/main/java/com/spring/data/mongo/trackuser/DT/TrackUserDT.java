package com.spring.data.mongo.trackuser.DT;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "track_user")
@EqualsAndHashCode
@ToString
public class TrackUserDT {
    @Id
    @Field("_id")
    private ObjectId id;
    private String userName;
    private String companyId;
    private String sessionId;
    private String tabId;
    private String moduleName;
    private String entityId;
    private Date startTime;
    private Date lastRecordedTime;
    private long duration;
    private boolean current;

}
