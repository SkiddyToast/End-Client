package paradox.client.main.utils;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glScissor;
import static org.lwjgl.opengl.GL11.glVertex3d;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class RenderUtils
{
	public static void entityESPBox(Entity entity, int mode)
    {
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(2.0F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        if(mode == 0)// Enemy
            GL11.glColor4d(
                1 - Minecraft.getMinecraft().player
                    .getDistanceToEntity(entity) / 40,
                Minecraft.getMinecraft().player.getDistanceToEntity(entity) / 40,
                0, 0.5F);
        else if(mode == 1)// Friend
            GL11.glColor4d(0, 0, 1, 0.5F);
        else if(mode == 2)// Other
            GL11.glColor4d(1, 1, 0, 0.5F);
        else if(mode == 3)// Target
            GL11.glColor4d(1, 0, 0, 0.5F);
        else if(mode == 4)// Team
            GL11.glColor4d(0, 1, 0, 0.5F);
        Minecraft.getMinecraft().getRenderManager();
        RenderGlobal.drawSelectionBoundingBox(
            new AxisAlignedBB(
                entity.boundingBox.minX
                    - 0.05
                    - entity.posX
                    + (entity.posX - Minecraft.getMinecraft()
                        .getRenderManager().renderPosX),
                entity.boundingBox.minY
                    - entity.posY
                    + (entity.posY - Minecraft.getMinecraft()
                        .getRenderManager().renderPosY),
                entity.boundingBox.minZ
                    - 0.05
                    - entity.posZ
                    + (entity.posZ - Minecraft.getMinecraft()
                        .getRenderManager().renderPosZ),
                entity.boundingBox.maxX
                    + 0.05
                    - entity.posX
                    + (entity.posX - Minecraft.getMinecraft()
                        .getRenderManager().renderPosX),
                entity.boundingBox.maxY
                    + 0.1
                    - entity.posY
                    + (entity.posY - Minecraft.getMinecraft()
                        .getRenderManager().renderPosY),
                entity.boundingBox.maxZ
                    + 0.05
                    - entity.posZ
                    + (entity.posZ - Minecraft.getMinecraft()
                        .getRenderManager().renderPosZ)), 1F, 0.5F, 0.5F, 1F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
    }
	
	public static void drawTracerLine(double x, double y, double z, float red, float green, float blue, float alpha, float lineWdith) {
		GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        // GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(lineWdith);
        GL11.glColor4f(red, green, blue, alpha);
        GL11.glBegin(2);
        GL11.glVertex3d(0.0D, Minecraft.getMinecraft().player.getEyeHeight(), 0.0D);
        GL11.glVertex3d(x, y, z);
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_BLEND);
        // GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
	}
	
	public static void blockESPBox(BlockPos blockPos)
    {
        double x =
            blockPos.getX()
                - Minecraft.getMinecraft().getRenderManager().renderPosX;
        double y =
            blockPos.getY()
                - Minecraft.getMinecraft().getRenderManager().renderPosY;
        double z =
            blockPos.getZ()
                - Minecraft.getMinecraft().getRenderManager().renderPosZ;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(2.0F);
        GL11.glColor4d(0, 1, 0, 0.15F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        //drawColorBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
        GL11.glColor4d(0, 0, 1, 0.5F);
        RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0F, y + 1.0F, z + 1.0F), 0F, 1F, 0.0F, 1F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
    }
	public static void shulkerESPBox(BlockPos blockPos)
    {
        double x =
            blockPos.getX()
                - Minecraft.getMinecraft().getRenderManager().renderPosX;
        double y =
            blockPos.getY()
                - Minecraft.getMinecraft().getRenderManager().renderPosY;
        double z =
            blockPos.getZ()
                - Minecraft.getMinecraft().getRenderManager().renderPosZ;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(2.0F);
        GL11.glColor4d(0, 1, 0, 0.15F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        //drawColorBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
        GL11.glColor4d(0, 0, 1, 0.5F);
        RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0F, y + 1.0F, z + 1.0F), 1F, 0.0F, 0.5F, 1F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
    }
	public static void enderChestESPBox(BlockPos blockPos)
    {
        double x =
            blockPos.getX()
                - Minecraft.getMinecraft().getRenderManager().renderPosX;
        double y =
            blockPos.getY()
                - Minecraft.getMinecraft().getRenderManager().renderPosY;
        double z =
            blockPos.getZ()
                - Minecraft.getMinecraft().getRenderManager().renderPosZ;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(2.0F);
        GL11.glColor4d(0, 1, 0, 0.15F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        //drawColorBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
        GL11.glColor4d(0, 0, 1, 0.5F);
        RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0F, y + 1.0F, z + 1.0F), 1F, 0.0F, 1F, 1F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
    }
}
