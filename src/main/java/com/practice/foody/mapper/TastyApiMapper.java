package com.practice.foody.mapper;

import com.practice.foody.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TastyApiMapper {
    public Recipe mapToRecipe(RecipeDto recipeDto) {
        return new Recipe(recipeDto.getId(), recipeDto.getName(), recipeDto.getDescription(), recipeDto.getMealType(), mapToInstructionList(recipeDto.getInstructions()), mapToSectionList(recipeDto.getSections()), mapToNutrition(recipeDto.getNutrition()));
    }
    public Instruction mapToInstruction(InstructionDto instructionDto) {
        return new Instruction(instructionDto.getId(), instructionDto.getPosition(), instructionDto.getText());
    }
    public List<Instruction> mapToInstructionList(List<InstructionDto> instructionDtos) {
        return instructionDtos.stream().map(this::mapToInstruction).toList();
    }
    public Section mapToSection (SectionDto sectionDto) {
        return new Section(sectionDto.getName(),sectionDto.getPosition(),mapToComponentList(sectionDto.getComponents()));
    }
    public List<Section> mapToSectionList(List<SectionDto> sectionDtos) {
        return sectionDtos.stream().map(this::mapToSection).toList();
    }
    public Component mapToComponent(ComponentDto componentDto) {
        return new Component(componentDto.getId(), componentDto.getPosition(), componentDto.getText(),mapToMeasurementsList(componentDto.getMeasurements()), mapToIngredient(componentDto.getIngredient()));
    }
    public List<Component> mapToComponentList(List<ComponentDto> componentDtos) {
        return componentDtos.stream().map(this::mapToComponent).toList();
    }
    public Measurements mapToMeasurements (MeasurementsDto measurementsDto) {
        return new Measurements(measurementsDto.getId(), measurementsDto.getQuantity(), mapToUnit(measurementsDto.getUnit()));
    }
    public List<Measurements> mapToMeasurementsList (List<MeasurementsDto> measurementsDtos) {
        return measurementsDtos.stream().map(this::mapToMeasurements).toList();
    }
    public Ingredient mapToIngredient(IngredientDto ingredientDto) {
        return new Ingredient(ingredientDto.getId(), ingredientDto.getName());
    }
    public Unit mapToUnit (UnitDto unitDto) {
        return new Unit(unitDto.getSystem(), unitDto.getName());
    }
    public Nutrition mapToNutrition(NutritionDto nutritionDto) {
        return new Nutrition(nutritionDto.getProtein(), nutritionDto.getFat(), nutritionDto.getCalories(), nutritionDto.getSugar(), nutritionDto.getCarbohydrates(), nutritionDto.getFiber());
    }
}
