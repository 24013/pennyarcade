package pennyarcade.block.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMiniEnderman extends ModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer RightArm;
    ModelRenderer LeftArm;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
  
  public ModelMiniEnderman()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(-4F, -8F, -4F, 4, 4, 4);
      Head.setRotationPoint(2F, 7F, 2F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 16, 8);
      Body.addBox(-4F, 0F, -2F, 4, 6, 2);
      Body.setRotationPoint(2F, 3F, 1F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      RightArm = new ModelRenderer(this, 28, 0);
      RightArm.addBox(-1F, -2F, -1F, 1, 15, 1);
      RightArm.setRotationPoint(-2F, 5F, 0.5F);
      RightArm.setTextureSize(64, 32);
      RightArm.mirror = true;
      setRotation(RightArm, 0F, 0F, 0F);
      //LeftArm.mirror = true;
      LeftArm = new ModelRenderer(this, 28, 0);
      LeftArm.addBox(-1F, -2F, -1F, 1, 15, 1);
      LeftArm.setRotationPoint(3F, 5F, 0.5F);
      LeftArm.setTextureSize(64, 32);
      LeftArm.mirror = true;
      setRotation(LeftArm, 0F, 0F, 0F);
      LeftArm.mirror = false;
      RightLeg = new ModelRenderer(this, 28, 0);
      RightLeg.addBox(-1F, 0F, -1F, 1, 15, 1);
      RightLeg.setRotationPoint(-0.5F, 9F, 0.5F);
      RightLeg.setTextureSize(64, 32);
      RightLeg.mirror = true;
      setRotation(RightLeg, 0F, 0F, 0F);
      //LeftLeg.mirror = true;
      LeftLeg = new ModelRenderer(this, 28, 0);
      LeftLeg.addBox(-1F, 0F, -1F, 1, 15, 1);
      LeftLeg.setRotationPoint(1.5F, 9F, 0.5F);
      LeftLeg.setTextureSize(64, 32);
      LeftLeg.mirror = true;
      setRotation(LeftLeg, 0F, 0F, 0F);
      LeftLeg.mirror = false;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Head.render(f5);
    Body.render(f5);
    RightArm.render(f5);
    LeftArm.render(f5);
    RightLeg.render(f5);
    LeftLeg.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
