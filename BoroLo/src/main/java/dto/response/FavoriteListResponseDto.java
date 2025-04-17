package dto.response;

import java.util.List;

public class FavoriteListResponseDto {
    private List<ItemSummaryDto> favorites;

    public List<ItemSummaryDto> getFavorites() { return favorites; }
    public void setFavorites(List<ItemSummaryDto> favorites) { this.favorites = favorites; }
}