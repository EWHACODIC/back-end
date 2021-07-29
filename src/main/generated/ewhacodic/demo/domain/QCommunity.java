package ewhacodic.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommunity is a Querydsl query type for Community
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommunity extends EntityPathBase<Community> {

    private static final long serialVersionUID = -893861021L;

    public static final QCommunity community = new QCommunity("community");

    public final NumberPath<Long> commentCount = createNumber("commentCount", Long.class);

    public final ListPath<CommunityComment, QCommunityComment> comments = this.<CommunityComment, QCommunityComment>createList("comments", CommunityComment.class, QCommunityComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> recommend = createNumber("recommend", Long.class);

    public final StringPath tag1 = createString("tag1");

    public final StringPath tag2 = createString("tag2");

    public final StringPath title = createString("title");

    public final NumberPath<Long> userCode = createNumber("userCode", Long.class);

    public final NumberPath<Long> view = createNumber("view", Long.class);

    public QCommunity(String variable) {
        super(Community.class, forVariable(variable));
    }

    public QCommunity(Path<? extends Community> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommunity(PathMetadata metadata) {
        super(Community.class, metadata);
    }

}

