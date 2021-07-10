package com.jyami.commitersewha.domain.userRank;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserRank is a Querydsl query type for UserRank
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserRank extends EntityPathBase<UserRank> {

    private static final long serialVersionUID = 324726181L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserRank userRank = new QUserRank("userRank");

    public final NumberPath<Long> commitCount = createNumber("commitCount", Long.class);

    public final NumberPath<Long> commitMaxCombo = createNumber("commitMaxCombo", Long.class);

    public final com.jyami.commitersewha.domain.githubInfo.QGithubInfo githubInfo;

    public final DatePath<java.time.LocalDate> localDate = createDate("localDate", java.time.LocalDate.class);

    public final NumberPath<Long> rankId = createNumber("rankId", Long.class);

    public final NumberPath<Long> score = createNumber("score", Long.class);

    public final BooleanPath week = createBoolean("week");

    public QUserRank(String variable) {
        this(UserRank.class, forVariable(variable), INITS);
    }

    public QUserRank(Path<? extends UserRank> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserRank(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserRank(PathMetadata metadata, PathInits inits) {
        this(UserRank.class, metadata, inits);
    }

    public QUserRank(Class<? extends UserRank> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.githubInfo = inits.isInitialized("githubInfo") ? new com.jyami.commitersewha.domain.githubInfo.QGithubInfo(forProperty("githubInfo")) : null;
    }

}

