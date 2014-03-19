package pennyarcade.block.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNyanCat extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer head;
    ModelRenderer ear1;
    ModelRenderer ear2;
    ModelRenderer tail;
  
  public ModelNyanCat()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      body = new ModelRenderer(this, 0, 0);
      body.addBox(0F, 0F, 0F, 3, 6, 6);
      body.setRotationPoint(-1.5F, 16.5F, -3F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 0);
      leg1.addBox(0F, 0F, 0F, 1, 2, 1);
      leg1.setRotationPoint(-1.5F, 22F, 1F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 0);
      leg2.addBox(0F, 0F, 0F, 1, 2, 1);
      leg2.setRotationPoint(0.5F, 22F, 1F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 0);
      leg3.addBox(0F, 0F, 0F, 1, 2, 1);
      leg3.setRotationPoint(0.5F, 22F, -2F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 0);
      leg4.addBox(0F, 0F, 0F, 1, 2, 1);
      leg4.setRotationPoint(-1.5F, 22F, -2F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      head = new ModelRenderer(this, 18, 0);
      head.addBox(0F, 0F, 0F, 5, 4, 3);
      head.setRotationPoint(-2.5F, 18F, -6F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      ear1 = new ModelRenderer(this, 12, 0);
      ear1.addBox(0F, 0F, 0F, 2, 2, 1);
      ear1.setRotationPoint(1F, 17F, -5F);
      ear1.setTextureSize(64, 32);
      ear1.mirror = true;
      setRotation(ear1, 0F, 0F, 0.8179294F);
      ear2 = new ModelRenderer(this, 12, 0);
      ear2.addBox(0F, 0F, 0F, 2, 2, 1);
      ear2.setRotationPoint(-1F, 17F, -5F);
      ear2.setTextureSize(64, 32);
      ear2.mirror = true;
      setRotation(ear2, 0F, 0F, 0.8179294F);
      tail = new ModelRenderer(this, 27, 0);
      tail.addBox(0F, 0F, 0F, 1, 3, 1);
      tail.setRotationPoint(-0.5F, 20F, 2.5F);
      tail.setTextureSize(64, 32);
      tail.mirror = true;
      setRotation(tail, 1.933288F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    head.render(f5);
    ear1.render(f5);
    ear2.render(f5);
    tail.render(f5);
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
