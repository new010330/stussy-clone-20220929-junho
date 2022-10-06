package com.stussy.stussclone20220929junho.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({
        ValidationGroups.NotBlankGroup.class,
        ValidationGroups.SizeCheckGroup.class,
        ValidationGroups.PatternCheckGroup.class,
        Default.class
})

public interface ValidationSequence {
}