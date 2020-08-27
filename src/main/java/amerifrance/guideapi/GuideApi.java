package amerifrance.guideapi;


import amerifrance.guideapi.guide.Guide;
import amerifrance.guideapi.test.TestGuide;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static net.minecraft.util.registry.Registry.ITEM;


public class GuideApi implements ModInitializer {

    public static final String MODID = "guide-api";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static final List<Guide> GUIDES = newArrayList();
    public static final List<Item> GUIDE_ITEMS = newArrayList();


    @Override
    public void onInitialize() {
        GUIDES.add(TestGuide.TEST_GUIDE_1);

        GUIDES.forEach(guide -> {
            //TODO allow Guide class to give item
            Item item = new ItemGuide(guide);
            Identifier identifier = new Identifier(MODID, guide.getId());

            Registry.register(ITEM, identifier, item);
            GUIDE_ITEMS.add(item);
        });
    }
}