package com.grimbo.parkbuilder.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class VelociraptorEntity extends AnimalEntity implements IAnimatable {



    private AnimationFactory factory = new AnimationFactory(this);

    protected VelociraptorEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);

    }

    private <E extends IAnimatable> PlayState animationPredicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("Velociraptor_walk.new", true));
        return PlayState.CONTINUE;

    }



    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<VelociraptorEntity>(this, "controller", 0, this::animationPredicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }


    @Override
    protected void registerGoals() {

        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.CHICKEN), false));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.RABBIT), false));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 50D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, .35D);
    }


    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return ModEntityTypes.VELOCIRAPTOR.get().create(this.world);

    }


    @Override
    public boolean func_241845_aY() {
        return this.isAlive();
    }



}
