//package com.mksherbini.jobzilla.adapters;
//
//import com.mksherbini.jobzilla.models.dto.SkillDto;
//import com.mksherbini.jobzilla.models.orm.Skill;
//import com.mksherbini.jobzilla.models.orm.Technology;
//import com.mksherbini.jobzilla.models.orm.ids.SkillId;
//import com.mksherbini.jobzilla.repos.SkillsJpaRepo;
//import com.mksherbini.jobzilla.repos.TechnologiesJpaRepo;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//@RequiredArgsConstructor
//public class SkillDtoToOrmAdapter implements GenericAdapter<SkillDto, Skill> {
//    private final ModelMapper modelMapper;
//    private final SkillsJpaRepo skillsJpaRepo;
//    private final TechnologiesJpaRepo technologiesJpaRepo;
//
//    @Override
//    public Skill adapt(SkillDto o) {
//        Optional<Technology> foundTech = technologiesJpaRepo.findById(o.getName());
//
//        if (foundTech.isEmpty()) {
//            var tech = new Technology(o.getName());
//            foundTech = Optional.of(
//                    technologiesJpaRepo.save(new Technology(o.getName())));
//        }
//
//        Optional<Skill> foundSkill = skillsJpaRepo.findById(new SkillId(foundTech.get(), o.getLevel()));
//
//        if (foundSkill.isEmpty()) {
//            foundSkill = Optional.of(
//                    skillsJpaRepo.save(new Skill(foundTech.get(), o.getLevel())));
//        }
//
//        return foundSkill.get();
//    }
//}
