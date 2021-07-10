package com.jyami.commitersewha.domain.githubRepoInfo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGithubRepoInfo is a Querydsl query type for GithubRepoInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGithubRepoInfo extends EntityPathBase<GithubRepoInfo> {

    private static final long serialVersionUID = 573413477L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGithubRepoInfo githubRepoInfo = new QGithubRepoInfo("githubRepoInfo");

    public final NumberPath<Long> additions = createNumber("additions", Long.class);

    public final NumberPath<Long> commits = createNumber("commits", Long.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> deletions = createNumber("deletions", Long.class);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> forksCount = createNumber("forksCount", Integer.class);

    public final com.jyami.commitersewha.domain.githubInfo.QGithubInfo githubInfo;

    public final StringPath htmlUrl = createString("htmlUrl");

    public final StringPath language = createString("language");

    public final StringPath name = createString("name");

    public final StringPath owner = createString("owner");

    public final NumberPath<Long> repoInfoId = createNumber("repoInfoId", Long.class);

    public final NumberPath<Integer> stargazersCount = createNumber("stargazersCount", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> watchersCount = createNumber("watchersCount", Integer.class);

    public QGithubRepoInfo(String variable) {
        this(GithubRepoInfo.class, forVariable(variable), INITS);
    }

    public QGithubRepoInfo(Path<? extends GithubRepoInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGithubRepoInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGithubRepoInfo(PathMetadata metadata, PathInits inits) {
        this(GithubRepoInfo.class, metadata, inits);
    }

    public QGithubRepoInfo(Class<? extends GithubRepoInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.githubInfo = inits.isInitialized("githubInfo") ? new com.jyami.commitersewha.domain.githubInfo.QGithubInfo(forProperty("githubInfo")) : null;
    }

}

