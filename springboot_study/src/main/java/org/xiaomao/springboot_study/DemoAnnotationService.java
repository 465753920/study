package org.xiaomao.springboot_study;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    @Action(name = "DemoAnnotationService.add")
    public void add() {
    }
}
