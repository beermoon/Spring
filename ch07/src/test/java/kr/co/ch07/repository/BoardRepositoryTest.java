package kr.co.ch07.repository;


import jakarta.transaction.Transactional;
import kr.co.ch07.entity.board.Article;
import kr.co.ch07.entity.board.Comment;
import kr.co.ch07.entity.board.User;
import kr.co.ch07.repository.borad.ArticleRepository;
import kr.co.ch07.repository.borad.CommentRepository;
import kr.co.ch07.repository.borad.FileRepository;
import kr.co.ch07.repository.borad.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BoardRepositoryTest {


    @Autowired private ArticleRepository articleRepository;
    @Autowired private FileRepository fileRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private UserRepository userRepository;

    // 테스트1 - 사용자 등록
    @Test
    public void test1() {

        // given
        User user = User.builder()
                .uid("a103")
                .hp("010-1234-1003")
                .name("홍길동")
                .build();

        // when
        User savedUser =  userRepository.save(user);
        // then
        System.out.println(savedUser);

    }
    // 테스트2 - 글 등록
    @Test
    public void test2() {

        User user = User.builder()
                .uid("a101")
                .build();

        Article article = Article.builder()
                .title("제목1 입니다.")
                .content("내용1 입니다.")
                .user(user)
                .build();

        Article savedArticle = articleRepository.save(article);
        System.out.println(savedArticle);
    }
    // 테스트3 - 댓글 등록
    @Test
    public void test3() {

        User user = User.builder()
                .uid("a101")
                .build();

        Article article = Article.builder()
                .no(3)
                .build();

        Comment comment = Comment.builder()
                .article(article)
                .content("댓글1 입니다.")
                .user(user)
                .build();

       Comment savedComment = commentRepository.save(comment);

       System.out.println(savedComment);
    }
    // 테스트4 - 파일 등록
    @Transactional
    @Test
    public void test4() {


        }
    }
    // 테스트5 - 전체 글 조회 등록
    @Test
    public void test5() {
 /*
         엔티티가 관계 설정으로 되어있을 경우에 해당 엔티티를 조회할 때 관계가 맺어진 다른 엔티티도 함께 조회도기 때문에
         단일 트랜잭션으로 처리해야 됨 그렇지 않으면 no session 에러 발생 -> @Transactional 어노테이션 선언
        */
        List<Article> articleList = articleRepository.findAll();

//        System.out.println(articleList);


        for (Article article : articleList) {

            System.out.println(article.toString());
            List<Comment> commentList = article.getComment();
            for(Comment comment : commentList){
                System.out.println(comment);
            }



    }
    // 테스트6 - 글 조회
    @Test
    public void test6() {

     Optional<Article> optArticle =  articleRepository.findBy(3L);

     if(optArticle.isPresent()){

         Article article = optArticle.get();
         System.out.println(article);
     }

    }


}
