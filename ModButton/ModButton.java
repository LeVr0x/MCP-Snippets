package pl.h00p03.client.utils;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import pl.h00p03.client.mods.Mod;
import pl.h00p03.client.utils.animations.Animation;
import pl.h00p03.client.utils.animations.util.Easings;
import pl.h00p03.client.utils.font.FontUtil;

public class ModButton {
	public double x, y, w, h;
	public Mod m;
	public String n, s;
	ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());

	public ModButton(Mod mod, double x, double y, double width, double height, String s, String n) {
		this.x = x;
		this.y = y;
		this.w = width;
		this.h = height;
		this.m = mod;
		this.s = s;
		this.n = n;
	}

	public void draw() {
		GuiUtils.drawSmoothRoundedRect(x, y, x + w - 40, y + h + 40, 30,
				new Color(36, 36, 36, 200).getRGB());
		GuiUtils.drawSmoothRoundedRect(x + 27, y + 7, x + w - 65, y + h - 7, 30,
				new Color(50, 50, 50, 170).getRGB());
		GuiUtils.drawRoundedOutline(x, y, x + w - 40, y + h + 40, 30, 5, Color());
		GlStateManager.color(255, 255, 255);
		FontUtil.normal.drawStringWithShadow(s,x + 110 - Minecraft.getMinecraft().fontRendererObj.getStringWidth(n), y + 75, new Color(255, 255, 255).getRGB());
		GuiUtils.drawScaledLogo(x + 70, y + 30, 40, "Client/Icons/", n);
		GlStateManager.resetColor();
	}

	private int Color() {
		if (m.isEnabled()) {
			return new Color(0, 255, 0, 180).getRGB();
		} else {
			return new Color(255, 0, 0, 180).getRGB();
		}
	}

	public void onClick(int mouseX, int mouseY, int mouseButton) {
		if (mouseX >= x - 2 && mouseX <= x + w - 39&& mouseY >= y - 2 && mouseY <= y + h + 41) {

			if (m.isEnabled()) {
				m.setEnabled(false);
				System.out.println("Mod Disabled");
			} else {
				m.setEnabled(true);
				System.out.println("Mod Enabled");
			}
		}

		try {
			ModToggle.saveEnabled(m);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}