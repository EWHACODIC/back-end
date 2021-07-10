package com.jyami.commitersewha.domain.githubInfo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGithubInfo is a Querydsl query type for GithubInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGithubInfo extends EntityPathBase<GithubInfo> {

    private static final long serialVersionUID = 1699695653L;

    public static final QGithubInfo githubInfo = new QGithubInfo("githubInfo");

    public final com.jyami.commitersewha.domain.QBaseTime _super = new com.jyami.commitersewha.domain.QBaseTime(this);

    public final StringPath authorId = createString("authorId");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath email = createString("email");

    public final StringPath imageUrl = createString("imageUrl");

    public final NumberPath<Long> infoId = createNumber("infoId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final NumberPath<Long> providerId = createNumber("providerId", Long.class);

    public final StringPath token = createString("token");

    public final NumberPath<User> user = createNumber("user", User.class);

    public QGithubInfo(String variable) {
        super(GithubInfo.class, forVariable(variable));
    }

    public QGithubInfo(Path<? extends GithubInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGithubInfo(PathMetadata metadata) {
        super(GithubInfo.class, metadata);
    }

}

