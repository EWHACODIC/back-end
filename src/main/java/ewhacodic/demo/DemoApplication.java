package ewhacodic.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
// ranking
import ewhacodic.demo.rankMember.Member;
import ewhacodic.demo.rankMember.MemberRepository;
import org.springframework.boot.CommandLineRunner; //이건 뭐지
import static java.util.Arrays.asList;
@EnableJpaAuditing
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public class CacheDemoApplication implements CommandLineRunner {

		private final MemberRepository memberRepository;

		public CacheDemoApplication(MemberRepository memberRepository) {
			this.memberRepository = memberRepository;
		}

		public void main(String[] args) {
			SpringApplication.run(CacheDemoApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			this.memberRepository.saveAll(
					asList(
							new Member("minsoo"),
							new Member("wonwoo"),
							new Member("toby"),
							new Member("adel"),
							new Member("manbok")
					)
			);
		}
	}
}