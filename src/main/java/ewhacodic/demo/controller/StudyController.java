package ewhacodic.demo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import ewhacodic.demo.dto.StudyDto;
import ewhacodic.demo.dto.StudyListDto;
import ewhacodic.demo.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/study")
public class StudyController {
    @Autowired
    private StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    //목록 전체 불러오기
    @GetMapping(value="/list")
    public List<StudyListDto> getStudyList(){
        return studyService.getStudyList();
    }

    //스터디 모집하기
    @PostMapping("/new")
    public ResponseEntity<String> recruitment(@RequestBody StudyDto studyDto){
        System.out.println("controller");
        studyService.saveStudy(studyDto);
        return ResponseEntity.ok("ok");
    }

    //스터디 상세정보 조회
    @GetMapping("/{studyId}")
    public StudyDto detail(@PathVariable("studyId") Long studyId){
        StudyDto studyDto = studyService.getStudyOnly(studyId);
        return studyDto;
    }

    //최근 8개 조회
    @GetMapping("/list/recent")
    public List<StudyListDto> getRecentStudyList(){
        return studyService.getRecentStudyList();
    }

    //스터디 총 개수 조회
    @GetMapping("/list/count")
    public Long totalStudyCount(){
        return studyService.totalCount();
    }

    //스터디 참여하기
    @GetMapping("/{studyId}/join")
    public ResponseEntity<String> joinStudy(@PathVariable("studyId") Long studyId,
                                            @RequestParam("userId") Long userId,
                                            @RequestParam(value = "password", required = false) Long password) throws Exception{
        if (studyService.joinStudy(studyId, userId, password) == null)
            throw new Exception();
        return ResponseEntity.ok("ok");
    }
}