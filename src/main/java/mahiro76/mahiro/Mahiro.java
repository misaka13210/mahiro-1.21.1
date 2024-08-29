package mahiro76.mahiro;

import mahiro76.mahiro.registry.MahiroItemGroup;
import mahiro76.mahiro.registry.MahiroItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mojang.text2speech.Narrator.LOGGER;

public class Mahiro implements ModInitializer {
	// 此记录器用于将文本写入控制台和日志文件。
	// 最好使用 mod id 作为 logger 的名称。
	// 这样，就可以清楚地知道哪个 Mod 编写了信息、警告和错误。
	public static final String MOD_ID = "mahiro";
    public static final Logger LOGGER = LoggerFactory.getLogger("Mahiro");

	@Override
	public void onInitialize() {
		// 此代码在 Minecraft 处于 mod-load-ready 状态后立即运行。
		// 但是，某些内容 （（如资源） ） 可能仍未初始化。
		// 请谨慎行事。

		LOGGER.info("Hello world!");
		MahiroItemGroup.registerModItemGroup();
		MahiroItems.registerMahiroItems();
	}
}