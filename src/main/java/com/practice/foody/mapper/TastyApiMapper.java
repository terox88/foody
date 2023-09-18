package com.practice.foody.mapper;

import com.practice.foody.domain.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class TastyApiMapper {
    public Recipe mapToRecipe(RecipeDto recipeDto) {
        return new Recipe(recipeDto.getId(), recipeDto.getName(), recipeDto.getDescription(), recipeDto.getMealType(), mapToInstructionList(recipeDto.getInstructions()), mapToSectionList(recipeDto.getSections()), mapToNutrition(recipeDto.getNutrition()));
    }
    public RecipeDto mapToRecipeDto(Recipe recipe) {
        return new RecipeDto(recipe.getId(), recipe.getName(), recipe.getDescription(), mapToInstructionDtoList(recipe.getInstructions()), mapToSectionDtoList(recipe.getSections()), mapToNutritionDto(recipe.getNutrition()), recipe.getMealType());
    }
    public List<Recipe> mapToRecipeList(List<RecipeDto> recipeDtos) {
        return recipeDtos.stream().map(this::mapToRecipe).toList();
    }
    public List<RecipeDto> mapToRecipeDtoList(List<Recipe> recipe) {
        return recipe.stream().map(this::mapToRecipeDto).toList();
    }
    public Instruction mapToInstruction(InstructionDto instructionDto) {
        return new Instruction(instructionDto.getId(), instructionDto.getPosition(), instructionDto.getText());
    }
    public InstructionDto mapToInstructionDto(Instruction instruction) {
        return new InstructionDto(instruction.getId(), instruction.getPosition(), instruction.getText());
    }
    public List<Instruction> mapToInstructionList(List<InstructionDto> instructionDtos) {
        return instructionDtos.stream().map(this::mapToInstruction).toList();
    }
    public List<InstructionDto> mapToInstructionDtoList(List<Instruction> instruction) {
        return instruction.stream().map(this::mapToInstructionDto).toList();
    }
    public Section mapToSection (SectionDto sectionDto) {
        return new Section(sectionDto.getName(),sectionDto.getPosition(),mapToComponentList(sectionDto.getComponents()));
    }
    public SectionDto mapToSectionDto (Section section) {
        return new SectionDto(section.getName(),section.getPosition(),mapToComponentDtoList(section.getComponents()));
    }
    public List<Section> mapToSectionList(List<SectionDto> sectionDtos) {
        return sectionDtos.stream().map(this::mapToSection).toList();
    }
    public List<SectionDto> mapToSectionDtoList(List<Section> section) {
        return section.stream().map(this::mapToSectionDto).toList();
    }
    public Component mapToComponent(ComponentDto componentDto) {
        return new Component(componentDto.getId(), componentDto.getPosition(), componentDto.getText(),mapToMeasurementsList(componentDto.getMeasurements()), componentDto.getIngredient().getName());
    }
    public ComponentDto mapToComponentDto(Component component) {
        return new ComponentDto(component.getId(), component.getPosition(), component.getText(),mapToMeasurementsDtoList(component.getMeasurements()), new  IngredientDto(component.getIngredient()));
    }

    public List<Component> mapToComponentList(List<ComponentDto> componentDtos) {
        return componentDtos.stream().map(this::mapToComponent).toList();
    }
    public List<ComponentDto> mapToComponentDtoList(List<Component> component) {
        return component.stream().map(this::mapToComponentDto).toList();
    }

    public Measurements mapToMeasurements (MeasurementsDto measurementsDto) {
        return new Measurements(measurementsDto.getId(), measurementsDto.getQuantity(), mapToUnit(measurementsDto.getUnit()));

    }
    public MeasurementsDto mapToMeasurementsDto (Measurements measurements) {
        return new MeasurementsDto(measurements.getId(), measurements.getQuantity(), mapToUnitDto(measurements.getUnit()));
    }
    public List<Measurements> mapToMeasurementsList (List<MeasurementsDto> measurementsDtos) {
        return measurementsDtos.stream().map(this::mapToMeasurements).toList();
    }
    public List<MeasurementsDto> mapToMeasurementsDtoList (List<Measurements> measurements) {
        return measurements.stream().map(this::mapToMeasurementsDto).toList();
    }
    public Unit mapToUnit (UnitDto unitDto) {
        return new Unit(unitDto.getSystem(), unitDto.getName());
    }
    public UnitDto mapToUnitDto (Unit unit) {
        return new UnitDto(unit.getSystem(), unit.getName());
    }
    public Nutrition mapToNutrition(NutritionDto nutritionDto) {
        return new Nutrition(nutritionDto.getProtein(), nutritionDto.getFat(), nutritionDto.getCalories(), nutritionDto.getSugar(), nutritionDto.getCarbohydrates(), nutritionDto.getFiber());
    }
    public NutritionDto mapToNutritionDto(Nutrition nutrition) {
        return new NutritionDto(nutrition.getProtein(), nutrition.getFat(),nutrition.getCalories(), nutrition.getSugar(), nutrition.getCarbohydrates(), nutrition.getFiber());
    }
}
